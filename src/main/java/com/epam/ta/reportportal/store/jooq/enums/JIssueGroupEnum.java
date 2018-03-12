/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.store.jooq.enums;


import com.epam.ta.reportportal.store.jooq.JPublic;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum JIssueGroupEnum implements EnumType {

    PRODUCT_BUG("PRODUCT_BUG"),

    AUTOMATION_BUG("AUTOMATION_BUG"),

    SYSTEM_ISSUE("SYSTEM_ISSUE"),

    TO_INVESTIGATE("TO_INVESTIGATE"),

    NO_DEFECT("NO_DEFECT");

    private final String literal;

    private JIssueGroupEnum(String literal) {
        this.literal = literal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return getSchema() == null ? null : getSchema().getCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return JPublic.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "issue_group_enum";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLiteral() {
        return literal;
    }
}
