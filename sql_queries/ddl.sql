create table category (
	category_name varchar(255) not null,
	category_description varchar(2000),
	primary key (category_name)
);

create table client_lead (
	client_type varchar(255) not null,
	primary key (client_type)
);

create table domain (
	domain_name varchar(255) not null,
	primary key (domain_name)
);

create table feature (
	feature_ref varchar(500) not null,
	artifact_detail varchar(1000),
	description varchar(2000),
	feature_extended boolean not null,
	feature_name varchar(1000),
	type varchar(1000),
	id int not null unique,
	used_year varchar(4),
	alternate_poc varchar(255),
	category_category_name varchar(255),
	poc varchar(255),
	sub_category_subcategory_name varchar(255),
	primary key (feature_ref)
);
alter table if exists feature add constraint FK3a7thwude0xbb88wiq7pn0399 foreign key (alternate_poc) references userdata;
alter table if exists feature add constraint FK9rl7f7af1iyudpyt89nkh039n foreign key (category_category_name) references category;
alter table if exists feature add constraint FK8k832g1kft94mv8i1hhka6vbg foreign key (poc) references userdata;
alter table if exists feature add constraint FK12jpnwj8igex6pie5iqpm32xj foreign key (sub_category_subcategory_name) references sub_category;

create table practice (
	practice_name varchar(255) not null,
	primary key (practice_name)
);

create table project (
	project_name varchar(255) not null,
	brandnames varchar(2000),
	id int not null unique,
	last_served_year varchar(4),
	multi_brand boolean not null,
	multi_site boolean not null,
	project_notes varchar(2000),
	client_base varchar(255),
	domain_domain_name varchar(255),
	practice_practice_name varchar(255),
	project_contact_point_user_id varchar(255),
	sector_sector_name varchar(255),
	primary key (project_name)
);
alter table if exists project add constraint FK9isliaene2ivvemfty3kmtljj foreign key (client_base) references client_lead;
alter table if exists project add constraint FKmm05x15hjad9eux54tb8sqou6 foreign key (domain_domain_name) references domain;
alter table if exists project add constraint FK9waorhldpn1yia3da9wekml7t foreign key (practice_practice_name) references practice;
alter table if exists project add constraint FKkl7dumscdloim3jjbu6xdnrx2 foreign key (project_contact_point_user_id) references userdata;
alter table if exists project add constraint FKh8thkr5hedfdy2oux1k2ogrdg foreign key (sector_sector_name) references sector;

create table project_regions (
	id int,
	project_project_name varchar(255) not null,
	regions_region_id varchar(255) not null,
	constraint PKid primary key(id)
);
alter table if exists project_regions add constraint FKnv5eq9ih8oby9aicqdc2kxonu foreign key (regions_region_id) references region;
alter table if exists project_regions add constraint FKo4egcpc406vbcu020ijnhx2g4 foreign key (project_project_name) references project;

create table region (
	region_id varchar(255) not null,
	region_name varchar(255),
	primary key (region_id)
);

create table sector (
	sector_name varchar(255) not null,
	primary key (sector_name)
);

create table sub_category (
subcategory_name varchar(255) not null,
subcategory_description varchar(2000),
primary key (subcategory_name)
);

create table userdata (
	user_id varchar(255) not null,
	company_id varchar(255),
	email varchar(255),
	first_name varchar(255),
	last_name varchar(255),
	primary key (user_id)
);
ALTER TABLE userdata ADD CONSTRAINT UK_uniqueconstraint UNIQUE (company_id, email);

create table feature_project (
	id int,
	feature_ref varchar(500) not null,
	project_name varchar(255) not null,
	artifact_detail varchar(1000),
	poc_user_id varchar(255),
	used_year varchar(4),
	feature_extended boolean not null,
	alternate_poc_user_id varchar(255),
	primary key (id),
	constraint FKlw2f4vwclcagweqcoshrgi7mo foreign key (project_name) references project(project_name),
	constraint FKc4451wbvhvn9jx1wfw82l2n1w foreign key (feature_ref) references feature(feature_ref)
);
