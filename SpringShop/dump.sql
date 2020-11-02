PGDMP         #            
    x            Shop2    13.0    13.0 -    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16571    Shop2    DATABASE     d   CREATE DATABASE "Shop2" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "Shop2";
                postgres    false            �            1259    16572    shuser    TABLE     �   CREATE TABLE public.shuser (
    iduser integer NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(200) NOT NULL,
    type integer NOT NULL
);
    DROP TABLE public.shuser;
       public         heap    postgres    false            �            1259    16575    User_iduser_seq    SEQUENCE     �   ALTER TABLE public.shuser ALTER COLUMN iduser ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."User_iduser_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    200            �            1259    16577    manufacture    TABLE     p   CREATE TABLE public.manufacture (
    idmanuf integer NOT NULL,
    namemanuf character varying(50) NOT NULL
);
    DROP TABLE public.manufacture;
       public         heap    postgres    false            �            1259    16580    manufacture_idmanuf_seq    SEQUENCE     �   ALTER TABLE public.manufacture ALTER COLUMN idmanuf ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.manufacture_idmanuf_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    202            �            1259    16582    prodtype    TABLE     k   CREATE TABLE public.prodtype (
    idtype integer NOT NULL,
    typename character varying(50) NOT NULL
);
    DROP TABLE public.prodtype;
       public         heap    postgres    false            �            1259    16585    prodtype_idtype_seq    SEQUENCE     �   ALTER TABLE public.prodtype ALTER COLUMN idtype ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.prodtype_idtype_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    204            �            1259    16587    product    TABLE     �   CREATE TABLE public.product (
    idproduct integer NOT NULL,
    nameprod character varying(50) NOT NULL,
    manufacture integer NOT NULL,
    type integer NOT NULL,
    price bigint NOT NULL
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    16590    product_idproduct_seq    SEQUENCE     �   ALTER TABLE public.product ALTER COLUMN idproduct ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_idproduct_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    206            �            1259    16592    productview    VIEW     !  CREATE VIEW public.productview AS
 SELECT p.idproduct,
    p.nameprod,
    pt.typename,
    m.namemanuf,
    p.price
   FROM ((public.product p
     JOIN public.manufacture m ON ((p.manufacture = m.idmanuf)))
     JOIN public.prodtype pt ON ((p.type = pt.idtype)))
  ORDER BY p.idproduct;
    DROP VIEW public.productview;
       public          postgres    false    204    206    206    206    206    206    204    202    202            �            1259    16596 	   userorder    TABLE     �   CREATE TABLE public.userorder (
    idorder integer NOT NULL,
    shuser integer NOT NULL,
    product integer NOT NULL,
    count integer NOT NULL
);
    DROP TABLE public.userorder;
       public         heap    postgres    false            �            1259    16599    userorder_idorder_seq    SEQUENCE     �   ALTER TABLE public.userorder ALTER COLUMN idorder ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.userorder_idorder_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �            1259    16601    userorderview    VIEW     �  CREATE VIEW public.userorderview AS
 SELECT uo.idorder,
    uo.shuser AS "user",
    p.nameprod,
    pt.typename,
    m.namemanuf,
    p.price,
    uo.count,
    (p.price * uo.count) AS finalprice
   FROM ((((public.userorder uo
     JOIN public.shuser u ON ((uo.shuser = u.iduser)))
     JOIN public.product p ON ((uo.product = p.idproduct)))
     JOIN public.manufacture m ON ((p.manufacture = m.idmanuf)))
     JOIN public.prodtype pt ON ((p.type = pt.idtype)));
     DROP VIEW public.userorderview;
       public          postgres    false    204    200    202    202    204    209    209    209    209    206    206    206    206    206            �            1259    16644    usertype    TABLE     g   CREATE TABLE public.usertype (
    id integer NOT NULL,
    nametype character varying(50) NOT NULL
);
    DROP TABLE public.usertype;
       public         heap    postgres    false            �            1259    16642    usertype_id_seq    SEQUENCE     �   ALTER TABLE public.usertype ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.usertype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    213            �          0    16577    manufacture 
   TABLE DATA           9   COPY public.manufacture (idmanuf, namemanuf) FROM stdin;
    public          postgres    false    202   �4       �          0    16582    prodtype 
   TABLE DATA           4   COPY public.prodtype (idtype, typename) FROM stdin;
    public          postgres    false    204   5       �          0    16587    product 
   TABLE DATA           P   COPY public.product (idproduct, nameprod, manufacture, type, price) FROM stdin;
    public          postgres    false    206   O5       �          0    16572    shuser 
   TABLE DATA           ?   COPY public.shuser (iduser, login, password, type) FROM stdin;
    public          postgres    false    200   �5       �          0    16596 	   userorder 
   TABLE DATA           D   COPY public.userorder (idorder, shuser, product, count) FROM stdin;
    public          postgres    false    209   �6       �          0    16644    usertype 
   TABLE DATA           0   COPY public.usertype (id, nametype) FROM stdin;
    public          postgres    false    213   �7       �           0    0    User_iduser_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."User_iduser_seq"', 26, true);
          public          postgres    false    201            �           0    0    manufacture_idmanuf_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.manufacture_idmanuf_seq', 3, true);
          public          postgres    false    203            �           0    0    prodtype_idtype_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.prodtype_idtype_seq', 3, true);
          public          postgres    false    205            �           0    0    product_idproduct_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.product_idproduct_seq', 5, true);
          public          postgres    false    207            �           0    0    userorder_idorder_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.userorder_idorder_seq', 93, true);
          public          postgres    false    210            �           0    0    usertype_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usertype_id_seq', 2, true);
          public          postgres    false    212            M           2606    16607    manufacture manufacture_pk 
   CONSTRAINT     ]   ALTER TABLE ONLY public.manufacture
    ADD CONSTRAINT manufacture_pk PRIMARY KEY (idmanuf);
 D   ALTER TABLE ONLY public.manufacture DROP CONSTRAINT manufacture_pk;
       public            postgres    false    202            O           2606    16609    manufacture manufacture_un 
   CONSTRAINT     Z   ALTER TABLE ONLY public.manufacture
    ADD CONSTRAINT manufacture_un UNIQUE (namemanuf);
 D   ALTER TABLE ONLY public.manufacture DROP CONSTRAINT manufacture_un;
       public            postgres    false    202            Q           2606    16611    prodtype prodtype_pk 
   CONSTRAINT     V   ALTER TABLE ONLY public.prodtype
    ADD CONSTRAINT prodtype_pk PRIMARY KEY (idtype);
 >   ALTER TABLE ONLY public.prodtype DROP CONSTRAINT prodtype_pk;
       public            postgres    false    204            S           2606    16613    product product_pk 
   CONSTRAINT     W   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pk PRIMARY KEY (idproduct);
 <   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pk;
       public            postgres    false    206            U           2606    16615    product product_un 
   CONSTRAINT     ^   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_un UNIQUE (nameprod, manufacture);
 <   ALTER TABLE ONLY public.product DROP CONSTRAINT product_un;
       public            postgres    false    206    206            I           2606    16617    shuser user_pk 
   CONSTRAINT     P   ALTER TABLE ONLY public.shuser
    ADD CONSTRAINT user_pk PRIMARY KEY (iduser);
 8   ALTER TABLE ONLY public.shuser DROP CONSTRAINT user_pk;
       public            postgres    false    200            K           2606    16619    shuser user_un 
   CONSTRAINT     J   ALTER TABLE ONLY public.shuser
    ADD CONSTRAINT user_un UNIQUE (login);
 8   ALTER TABLE ONLY public.shuser DROP CONSTRAINT user_un;
       public            postgres    false    200            W           2606    16621    userorder userorder_pk 
   CONSTRAINT     Y   ALTER TABLE ONLY public.userorder
    ADD CONSTRAINT userorder_pk PRIMARY KEY (idorder);
 @   ALTER TABLE ONLY public.userorder DROP CONSTRAINT userorder_pk;
       public            postgres    false    209            Y           2606    16648    usertype usertype_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.usertype
    ADD CONSTRAINT usertype_pk PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usertype DROP CONSTRAINT usertype_pk;
       public            postgres    false    213            [           2606    16650    usertype usertype_un 
   CONSTRAINT     S   ALTER TABLE ONLY public.usertype
    ADD CONSTRAINT usertype_un UNIQUE (nametype);
 >   ALTER TABLE ONLY public.usertype DROP CONSTRAINT usertype_un;
       public            postgres    false    213            ]           2606    16622    product product_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_fk FOREIGN KEY (type) REFERENCES public.prodtype(idtype) ON UPDATE CASCADE ON DELETE RESTRICT;
 <   ALTER TABLE ONLY public.product DROP CONSTRAINT product_fk;
       public          postgres    false    204    206    2897            ^           2606    16627    product product_fk_1    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_fk_1 FOREIGN KEY (manufacture) REFERENCES public.manufacture(idmanuf) ON UPDATE CASCADE ON DELETE RESTRICT;
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_fk_1;
       public          postgres    false    202    206    2893            \           2606    16651    shuser shuser_fk    FK CONSTRAINT     o   ALTER TABLE ONLY public.shuser
    ADD CONSTRAINT shuser_fk FOREIGN KEY (type) REFERENCES public.usertype(id);
 :   ALTER TABLE ONLY public.shuser DROP CONSTRAINT shuser_fk;
       public          postgres    false    200    213    2905            _           2606    16632    userorder userorder_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.userorder
    ADD CONSTRAINT userorder_fk FOREIGN KEY (product) REFERENCES public.product(idproduct) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.userorder DROP CONSTRAINT userorder_fk;
       public          postgres    false    2899    209    206            `           2606    16637    userorder userorder_fk_1    FK CONSTRAINT     �   ALTER TABLE ONLY public.userorder
    ADD CONSTRAINT userorder_fk_1 FOREIGN KEY (shuser) REFERENCES public.shuser(iduser) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.userorder DROP CONSTRAINT userorder_fk_1;
       public          postgres    false    2889    209    200            �   (   x�3�N�-.�K�2��I��/��2�t,(�I����� ���      �   '   x�3�,�M,*)���K�2�	�2���/-N����� ���      �   W   x��1� ���0��r��T������㼫f�S �����Y�P@S��G�$4#�Q�7�	�һn�8�Di���^��      �   �   x���K�0����-�1F��%�7m������s�/��3#B��t�p>��;��R��[U�A����,_�#I�z���=[�狟��6L "Rr�k�ɐ��TCe@�֒ㄠ~��DР�h�,�R5�H��]���<砌��-sm��%;L�DV��!!����Z�ϟ�s�����_l      �   �   x�5QKr@1Z�a:��]z�s|ӝ�A$n�V�H��̗�C�!S���1U�x��3�mp����h9gا����Լ���펐o�Sɵ��\R.䱧&bٛ%�2�Dd4�r["�P��ߓ�$$G2B�L���P�t��t(�A� ��L��]��K��R�+B3���	�('�dQ!�SI:Up�,�-s3~�̒G%X:M����P��X��U�6�˾��LBx�\�=q�g_4�����\C�      �      x�3�LL����2�,-N-����� : �     