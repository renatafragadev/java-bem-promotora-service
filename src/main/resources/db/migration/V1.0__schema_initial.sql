create table `bank`
(
    `id`            bigint auto_increment
        primary key,
    `agency_digit`  int          null,
    `agency_number` int          null,
    `cep`           varchar(255) null
);


create table `client`
(
    `id`                     bigint       not null
        primary key,
    `account_digit`          int          null,
    `account_number`         int          null,
    `cep`                    varchar(255) null,
    `date_of_birth`          datetime     null,
    `document`               varchar(255) null,
    `document_type`          varchar(4)   null,
    `email`                  varchar(255) null,
    `full_name`              varchar(255) null,
    `issuing_date`           datetime     null,
    `issuing_organ`          varchar(255) null,
    `phone_number`           varchar(255) null,
    `rg`                     varchar(255) null,
    `sex`                    varchar(1)   null,
    `state`                  varchar(255) null,
    `bank_id`                bigint       null,
    `agreement`              varchar(5)   null,
    `agreement_registration` varchar(255) null,
    `mother_name`            varchar(255) null
);

create index fk_e8oc3sulkpvxdascbnkpchunx
    on client (bank_id);

create table `document`
(
    `id`        bigint auto_increment
        primary key,
    `content`   varchar(255) null,
    `file_name` varchar(255) null,
    `format`    varchar(255) null,
    `send_type` varchar(5)   null,
    `person_id` bigint       null
);

create table `employee`
(
    `id`             bigint       not null
        primary key,
    `account_digit`  int          null,
    `account_number` int          null,
    `cep`            varchar(255) null,
    `date_of_birth`  datetime     null,
    `document`       varchar(255) null,
    `document_type`  varchar(4)   null,
    `email`          varchar(255) null,
    `full_name`      varchar(255) null,
    `issuing_date`   datetime     null,
    `issuing_organ`  varchar(255) null,
    `phone_number`   varchar(255) null,
    `rg`             varchar(255) null,
    `sex`            varchar(1)   null,
    `state`          varchar(255) null,
    `bank_id`        bigint       null,
    `registration`   datetime     null
);

create index fk_qa3iyxqxuv7rbtam6ejx4jp5l
    on employee (bank_id);

create table `person_id_gen`
(
    `gen_name` varchar(255) not null
        primary key,
    `gen_val`  bigint       null
);

create table proposal
(
    `id`              bigint auto_increment
        primary key,
    `amount`          decimal(19, 2) null,
    `created_at`      datetime       null,
    `expiry`          datetime       null,
    `installments`    int            null,
    `interest_rate`   decimal(19, 2) null,
    `proposal_status` int            null,
    `person_id`       bigint         null
);

