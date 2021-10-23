CREATE TABLE project (
    p_id integer identity NOT NULL,
    p_title varchar(80) NOT NULL,
    p_description varchar(500) NOT NULL,
    p_link varchar(255) NOT NULL
);
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8
--COLLATE = utf8_general_ci