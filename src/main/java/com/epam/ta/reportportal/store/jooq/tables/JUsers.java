/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.store.jooq.tables;


import com.epam.ta.reportportal.store.jooq.Indexes;
import com.epam.ta.reportportal.store.jooq.JPublic;
import com.epam.ta.reportportal.store.jooq.Keys;
import com.epam.ta.reportportal.store.jooq.enums.JUserRoleEnum;
import com.epam.ta.reportportal.store.jooq.enums.JUserTypeEnum;
import com.epam.ta.reportportal.store.jooq.tables.records.JUsersRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class JUsers extends TableImpl<JUsersRecord> {

    private static final long serialVersionUID = -837238256;

    /**
     * The reference instance of <code>public.users</code>
     */
    public static final JUsers USERS = new JUsers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JUsersRecord> getRecordType() {
        return JUsersRecord.class;
    }

    /**
     * The column <code>public.users.id</code>.
     */
    public final TableField<JUsersRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('users_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.users.login</code>.
     */
    public final TableField<JUsersRecord, String> LOGIN = createField("login", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.password</code>.
     */
    public final TableField<JUsersRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.email</code>.
     */
    public final TableField<JUsersRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.users.role</code>.
     */
    public final TableField<JUsersRecord, JUserRoleEnum> ROLE = createField("role", org.jooq.util.postgres.PostgresDataType.VARCHAR.asEnumDataType(com.epam.ta.reportportal.store.jooq.enums.JUserRoleEnum.class), this, "");

    /**
     * The column <code>public.users.type</code>.
     */
    public final TableField<JUsersRecord, JUserTypeEnum> TYPE = createField("type", org.jooq.util.postgres.PostgresDataType.VARCHAR.asEnumDataType(com.epam.ta.reportportal.store.jooq.enums.JUserTypeEnum.class), this, "");

    /**
     * The column <code>public.users.default_project_id</code>.
     */
    public final TableField<JUsersRecord, Integer> DEFAULT_PROJECT_ID = createField("default_project_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.users.full_name</code>.
     */
    public final TableField<JUsersRecord, String> FULL_NAME = createField("full_name", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<JUsersRecord, Object> METADATA = createField("metadata", org.jooq.impl.DefaultDataType.getDefaultDataType("jsonb"), this, "");

    /**
     * Create a <code>public.users</code> table reference
     */
    public JUsers() {
        this(DSL.name("users"), null);
    }

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    public JUsers(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    public JUsers(Name alias) {
        this(alias, USERS);
    }

    private JUsers(Name alias, Table<JUsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private JUsers(Name alias, Table<JUsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USERS_LOGIN_KEY, Indexes.USERS_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<JUsersRecord, Long> getIdentity() {
        return Keys.IDENTITY_USERS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<JUsersRecord> getPrimaryKey() {
        return Keys.USERS_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<JUsersRecord>> getKeys() {
        return Arrays.<UniqueKey<JUsersRecord>>asList(Keys.USERS_PK, Keys.USERS_LOGIN_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<JUsersRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JUsersRecord, ?>>asList(Keys.USERS__USERS_DEFAULT_PROJECT_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JUsers as(String alias) {
        return new JUsers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JUsers as(Name alias) {
        return new JUsers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JUsers rename(String name) {
        return new JUsers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JUsers rename(Name name) {
        return new JUsers(name, null);
    }
}
