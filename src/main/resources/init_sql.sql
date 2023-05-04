CREATE DATABASE exchange_rate_db;
create table public.minfin_rates
(
    id         bigserial
        primary key,
    ask        real not null,
    bid        real not null,
    comment    varchar(255),
    currency   varchar(255),
    date       varchar(255),
    desk       real not null,
    point_date varchar(255),
    trend_ask  real not null,
    trend_bid  real not null
);

alter table public.minfin_rates
    owner to postgres;

create table public.mono_bank_rates
(
    id             bigserial
        primary key,
    currency_codea integer not null,
    currency_codeb integer not null,
    date           bigint  not null,
    rate_buy       real    not null,
    rate_cross     real    not null,
    rate_sell      real    not null
);

alter table public.mono_bank_rates
    owner to postgres;

create table public.privat_bank_rates
(
    id       bigserial
        primary key,
    base_ccy varchar(255),
    buy      real not null,
    ccy      varchar(255),
    sale     real not null,
    date     varchar(255)
);

alter table public.privat_bank_rates
    owner to postgres;

create table public.exchange_rates
(
    id            bigserial
        primary key,
    buy           real    not null,
    currency_code integer not null,
    date          date,
    sale          real    not null
);

alter table public.exchange_rates
    owner to postgres;







