create table articles (
  id                        varchar(255) not null,
  alias                     TEXT,
  title                     TEXT,
  category_id               varchar(255),
  index                     boolean,
  created_at                timestamp,
  constraint pk_articles primary key (id))
;

create table categories (
  id                        varchar(255) not null,
  alias                     TEXT,
  name                      TEXT,
  display_order             bigint,
  show                      boolean,
  constraint pk_categories primary key (id))
;

create table comments (
  id                        varchar(255) not null,
  content                   TEXT,
  created_at                timestamp,
  paragraph_id              varchar(255),
  constraint pk_comments primary key (id))
;

create table configs (
  id                        varchar(255) not null,
  code                      TEXT,
  value                     TEXT,
  constraint pk_configs primary key (id))
;

create table notes (
  id                        varchar(255) not null,
  content                   TEXT,
  created_at                timestamp,
  paragraph_id              varchar(255),
  constraint pk_notes primary key (id))
;

create table paragraphs (
  id                        varchar(255) not null,
  content                   TEXT,
  article_id                varchar(255),
  display_order             bigint,
  constraint pk_paragraphs primary key (id))
;

create table users (
  id                        varchar(255) not null,
  email                     TEXT,
  name                      TEXT,
  salt                      TEXT,
  password                  TEXT,
  created_at                timestamp,
  last_login_at             timestamp,
  constraint pk_users primary key (id))
;

create sequence articles_seq;

create sequence categories_seq;

create sequence comments_seq;

create sequence configs_seq;

create sequence notes_seq;

create sequence paragraphs_seq;

create sequence users_seq;

alter table articles add constraint fk_articles_category_1 foreign key (category_id) references categories (id);
create index ix_articles_category_1 on articles (category_id);
alter table comments add constraint fk_comments_paragraph_2 foreign key (paragraph_id) references paragraphs (id);
create index ix_comments_paragraph_2 on comments (paragraph_id);
alter table notes add constraint fk_notes_paragraph_3 foreign key (paragraph_id) references paragraphs (id);
create index ix_notes_paragraph_3 on notes (paragraph_id);
alter table paragraphs add constraint fk_paragraphs_article_4 foreign key (article_id) references articles (id);
create index ix_paragraphs_article_4 on paragraphs (article_id);


