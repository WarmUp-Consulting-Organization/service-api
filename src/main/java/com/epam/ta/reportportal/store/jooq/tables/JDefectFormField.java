/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.store.jooq.tables;


import com.epam.ta.reportportal.store.jooq.Indexes;
import com.epam.ta.reportportal.store.jooq.JPublic;
import com.epam.ta.reportportal.store.jooq.Keys;
import com.epam.ta.reportportal.store.jooq.tables.records.JDefectFormFieldRecord;

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
public class JDefectFormField extends TableImpl<JDefectFormFieldRecord> {

    private static final long serialVersionUID = -1722007481;

    /**
     * The reference instance of <code>public.defect_form_field</code>
     */
    public static final JDefectFormField DEFECT_FORM_FIELD = new JDefectFormField();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JDefectFormFieldRecord> getRecordType() {
        return JDefectFormFieldRecord.class;
    }

    /**
     * The column <code>public.defect_form_field.id</code>.
     */
    public final TableField<JDefectFormFieldRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('defect_form_field_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.defect_form_field.bugtracking_system</code>.
     */
    public final TableField<JDefectFormFieldRecord, Integer> BUGTRACKING_SYSTEM = createField("bugtracking_system", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.defect_form_field.field_id</code>.
     */
    public final TableField<JDefectFormFieldRecord, String> FIELD_ID = createField("field_id", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.defect_form_field.type</code>.
     */
    public final TableField<JDefectFormFieldRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.defect_form_field.required</code>.
     */
    public final TableField<JDefectFormFieldRecord, Boolean> REQUIRED = createField("required", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.defect_form_field.values</code>.
     */
    public final TableField<JDefectFormFieldRecord, String[]> VALUES = createField("values", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * Create a <code>public.defect_form_field</code> table reference
     */
    public JDefectFormField() {
        this(DSL.name("defect_form_field"), null);
    }

    /**
     * Create an aliased <code>public.defect_form_field</code> table reference
     */
    public JDefectFormField(String alias) {
        this(DSL.name(alias), DEFECT_FORM_FIELD);
    }

    /**
     * Create an aliased <code>public.defect_form_field</code> table reference
     */
    public JDefectFormField(Name alias) {
        this(alias, DEFECT_FORM_FIELD);
    }

    private JDefectFormField(Name alias, Table<JDefectFormFieldRecord> aliased) {
        this(alias, aliased, null);
    }

    private JDefectFormField(Name alias, Table<JDefectFormFieldRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.DEFECT_FORM_FIELD_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<JDefectFormFieldRecord, Integer> getIdentity() {
        return Keys.IDENTITY_DEFECT_FORM_FIELD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<JDefectFormFieldRecord> getPrimaryKey() {
        return Keys.DEFECT_FORM_FIELD_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<JDefectFormFieldRecord>> getKeys() {
        return Arrays.<UniqueKey<JDefectFormFieldRecord>>asList(Keys.DEFECT_FORM_FIELD_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<JDefectFormFieldRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JDefectFormFieldRecord, ?>>asList(Keys.DEFECT_FORM_FIELD__DEFECT_FORM_FIELD_BUGTRACKING_SYSTEM_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JDefectFormField as(String alias) {
        return new JDefectFormField(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JDefectFormField as(Name alias) {
        return new JDefectFormField(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JDefectFormField rename(String name) {
        return new JDefectFormField(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JDefectFormField rename(Name name) {
        return new JDefectFormField(name, null);
    }
}
