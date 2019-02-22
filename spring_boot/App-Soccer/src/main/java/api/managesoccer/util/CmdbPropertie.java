package api.managesoccer.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("cmdb")

public class CmdbPropertie {
    private String resourceUrl;
    private List<Integer> resourcePort;

    @Override
    public String toString() {

        return "resourceUrl: " + this.resourceUrl + "\n"
                + "resourcePort: " + this.resourcePort + "\n";
    }

    public String getResourceUrl()
    {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl)
    {
        this.resourceUrl = resourceUrl;
    }

    public List<Integer> getResourcePort() {

        return resourcePort;
    }

    public void setResourcePort(List<Integer> resourcePort) {


        this.resourcePort = resourcePort;
    }

}
