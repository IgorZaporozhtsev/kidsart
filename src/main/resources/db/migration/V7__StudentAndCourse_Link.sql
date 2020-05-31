INSERT INTO student_course (student_id, course_id, start_date, end_date)
VALUES ('b4c67600-3c03-4eae-ad1a-de16cb9e5a64','188adc8a-2001-4df2-9880-468d4aa64064',
        NOW()::DATE, (NOW() + INTERVAL '1 YEAR')::DATE);
