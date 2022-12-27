CREATE TABLE IF NOT EXISTS cupidlovemicroservice.user (
    id uuid PRIMARY KEY,
    username text,
    email text,
    firstname text,
    lastname text,
    phone_number boolean,
    profile_photo text,
    cover_photo text,

    password text,
    max_password_attempt int,
    password_updated timestamp,

    user_information_id int,
    registration_date timestamp,
    last_connection date,
    premium boolean,
    active_date boolean,

    role int,

    recent_deactivate_date timestamp,
    email_verification boolean,
    phone_number_verification boolean,

    platform string,
    longitude string,
    latitude string,
);

CREATE  TABLE cupidlovemicroservice.`user_role`(
    id UUID,
    role_id int
)

CREATE TABLE cupidlovemicroservice.`user_role`(
    ID UUID,
    role string
)

CREATE TABLE cupidlovemicroservice.`user_information` (
    id uuid PRIMARY KEY,
    height int,
    weight int,
    country string,
    city string,
    eye_color string,
    hair string,
    bio string,
    age int,
    body_type string,
    education string,
    gender string,
    have_kids string,
    languages set<string>,
    interests set<string>,
    relationship_status string,
    smoke string,
    drinks string,
    occupation string,
    zodiac_sign,
    updated_at timestamp
);

CREATE TABLE cupidlovemicroservice.`user_payments`(
    product_id UUID PRIMARY KEY,
    product_name text,
    product_quantity int,
    product_price text,
    product_purchased_date timestamp,
    product_purchased_by int,
    product_card_detail text,
);

CREATE TABLE cupidlovemicroservice.`user_card_details`(
    id UUID PRIMARY KEY,
    user_id int,
    first_name string,
    last_name string,
    card_type string,
    card_name string,
    pin_code string,
    card_number string,
);

CREATE TABLE cupidlovemicroservice.`user_room`(
    id UUID PRIMARY KEY,
    room_name text,
    room_type text,
    room_description text,
    room_created_by int,
    room_updated_date timestamp,
    room_edited_by int,
    room_password string,
    room_isLocked boolean
)