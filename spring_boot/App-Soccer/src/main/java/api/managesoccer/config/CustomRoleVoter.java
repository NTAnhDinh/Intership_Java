package api.managesoccer.config;

import api.managesoccer.model.ManagePrivilege;
import api.managesoccer.model.Player;
import api.managesoccer.repository.PrivilegeRepository;
import api.managesoccer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.StringTokenizer;

@Component
public class CustomRoleVoter implements AccessDecisionVoter<FilterInvocation> {
	@Autowired
	PlayerService playerService;
	@Autowired
	PrivilegeRepository privilegeRepository;

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	@Override
	public int vote(Authentication authentication, FilterInvocation filterInvocation,
			Collection<ConfigAttribute> attributes) {
		/*
		 * Get user name from authentication
		 * 
		 * - check permission for user name with role and resource url
		 */
		String methodType = filterInvocation.getHttpRequest().getMethod();
		UserDetail userDetail = (UserDetail) authentication.getPrincipal();
		String userName = userDetail.getUsername();

		String resourceUlr = filterInvocation.getRequestUrl();

		StringTokenizer tokenizer = new StringTokenizer(resourceUlr, "?");
		String path = tokenizer.nextToken();
		System.out.println(path.substring(0, path.length()));
		if (checkPermission(methodType, path.substring(0, path.length()).trim(), userName))
			return ACCESS_GRANTED;
		else
			return ACCESS_DENIED;
	}

	public boolean checkPermission(String methodType, String resourceUlr, String userName) {
		Player player = playerService.findByUsername(userName);
		if (player == null) {
			throw new UsernameNotFoundException("UserName " + userName + " not exit");
		}
		StringTokenizer st = new StringTokenizer(resourceUlr, "/");
		String url = "/" + st.nextToken() + "/" + st.nextToken();
		try {
			ManagePrivilege managePrivilege = privilegeRepository.findByRoleId(player.getRole().getId(), url);
			System.out.println(player.getRole().getId() + " " + url + " " + methodType);
			System.out.println(managePrivilege.getStt());
			switch (methodType.toUpperCase()) {

			case "POST":
				if (managePrivilege.getInsert() == 1) {
					System.out.println(managePrivilege.getInsert());
					return true;
				}
				break;
			case "PUT":
				if (managePrivilege.getUpdate() == 1) {
					return true;
				}
				break;
			case "DELETE":
				if (managePrivilege.getDelete() == 1) {
					return true;
				}
				break;
			case "GET":
				if (managePrivilege.getRetrieve() == 1) {
					return true;
				}
				break;
			}
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return false;
	}

}
