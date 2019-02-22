package com.tma.tlab.api.query;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name="Subject.findAllWithDescription",
                query=QuerySubject.FIND_SUBJECT_WITH_DESCRIPTION),
})

@Entity
@Table(name="subject")
public class QuerySubject {
    public static  final String FIND_SUBJECT_WITH_DESCRIPTION =
            "SELECT sub FROM Subject as sub WHERE sub.description like :description ";
@Id
    private Integer id;

}
