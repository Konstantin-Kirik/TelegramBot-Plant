select * from employee;
select * from profession;
select employee.name, surname, patronymic, personnel_number, born, education, profession_name, building.number, level_skills
            from empt_prof_buld_skil
			join employee on empt_prof_buld_skil.employee_id = employee.id
            join profession on empt_prof_buld_skil.profession_id = profession.id
            join building on empt_prof_buld_skil.building_id = building.id
            join skills on empt_prof_buld_skil.skills_id = skills.id;
