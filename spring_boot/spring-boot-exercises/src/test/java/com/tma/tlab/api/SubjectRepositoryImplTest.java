package com.tma.tlab.api;

import com.tma.tlab.api.repository.SubjectRepositoryImpl;
import com.tma.tlab.api.model.Subject;
import com.tma.tlab.api.util.SubjectJpaRepository;
import io.katharsis.queryspec.FilterOperator;
import io.katharsis.queryspec.FilterSpec;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.resource.list.ResourceList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SubjectRepositoryImplTest {
    @InjectMocks
    private SubjectRepositoryImpl repository;

    @Mock
    private SubjectJpaRepository jpaRepository;

    @Before
    public void setUp() {
        // initiate something
    }

    @Test
    public void testFindAll() {
        QuerySpec spec = new QuerySpec(Subject.class);
        List<Subject> subjects = new ArrayList<>();
        Subject subject = new Subject();
        subject.setSubjectId(1L);
        subject.setDescription("Subject 1");
        subjects.add(subject);

        Subject subject1 = new Subject();
        subject1.setSubjectId(2L);
        subject1.setDescription("Subject 2");
        subjects.add(subject1);
        Mockito.when(jpaRepository.findAll()).thenReturn(subjects);
        ResourceList<Subject> resourceList = repository.findAll(spec);
//        Assert.assertEquals(2, resourceList.size());
//        Assert.assertEquals(subject, resourceList.get(0));
//        Assert.assertEquals(subject1, resourceList.get(1));
        FilterSpec filterSpec = new FilterSpec(Arrays.asList("subjectId"),
                FilterOperator.EQ, subject1.getSubjectId());
        spec.addFilter(filterSpec);
        resourceList = repository.findAll(spec);
//        Assert.assertEquals(1, resourceList.size());
//        Assert.assertEquals(subject, resourceList.get(0));
    }

    @Test
    public void testSave() {
        Subject subject1 = new Subject();
        subject1.setSubjectId(1L);
        subject1.setDescription("subject 1");
        repository.save(subject1);
        ArgumentCaptor<Subject> argumentCaptor = ArgumentCaptor.forClass(Subject.class);
        Mockito.verify(jpaRepository).save(argumentCaptor.capture());
        Assert.assertEquals(subject1, argumentCaptor.getValue());

    }

    @Test
    public void testDelete() {
        Subject subject1 = new Subject();
        subject1.setSubjectId(1l);
        subject1.setDescription("Subject 1");
        Mockito.when(jpaRepository.getOne(1l)).thenReturn(subject1);
        repository.delete(1l);
        ArgumentCaptor<Subject> argumentCaptor = ArgumentCaptor.forClass(Subject.class);
        Mockito.verify(jpaRepository).delete(argumentCaptor.capture());
        Assert.assertEquals(subject1, argumentCaptor.getValue());
    }

}
