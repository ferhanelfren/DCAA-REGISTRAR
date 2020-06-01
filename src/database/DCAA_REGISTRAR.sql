USE information_schema;

SELECT 
    student_records
FROM
    referential_constraints
WHERE
    constraint_schema = 'dcaa_registrar'
        AND referenced_table_name = 'enrolled_students'
        AND delete_rule = 'CASCADE'