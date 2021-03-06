insert into SPEAKER (ID, NAME, PATRONIM, SURNAME)
values (1, 'Владимир', 'Ильич', 'Ленин');

insert into SPEAKER (ID, NAME, PATRONIM, SURNAME)
values (2, 'Владимир', 'Владимирович', 'Путин');

insert into REPORT (ID, CONTENT, THEME, TIME, OWNER_ID)
VALUES (1,
        'Президент России Владимир Путин во вторник обратился к россиянам в связи с ситуацией по коронавирусу. ' ||
        'ТАСС публикует полный текст обращения главы государства.',
        'Коронавирус', parsedatetime('26-03-2020', 'dd-MM-yyyy'), 2);

insert into REPORT (ID, CONTENT, THEME, TIME, OWNER_ID)
VALUES (2,
        'Товарищи красноармейцы! Капиталисты Англии, Америки, Франции ведут войну против России. ' ||
        'Они мстят Советской рабочей и крестьянской республике за то, что она свергла власть помещиков ' ||
        'и капиталистов и дала тем пример для всех народов земли...',
        'Обращение к Красной Армии', parsedatetime('29-03-2019', 'dd-MM-yyyy'), 1);
