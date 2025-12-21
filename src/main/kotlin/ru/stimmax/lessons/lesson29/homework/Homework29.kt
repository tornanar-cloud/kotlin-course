package ru.stimmax.lessons.lesson29.homework

/*
Задание 1

Создай дата класс сотрудника компании Employee, содержащий:

имя
статус трудоустройства (булево)
дата рождения (строка)
должность CharacterTypes
список подчинённых с типом Employee

enum class CharacterTypes {
   CTO,
   UX_UI,
   CRM, // Customer Relationship Manager
   FRONTEND_DEV,
   TEAM_LEAD,
   BACKEND_DEV,
   PM,
   SYSADMIN,
   QA
}
 */
data class Employee(
    val name: String,
    var isEmployed: Boolean,
    val birthday: String,
    var position: CharacterTypes,
    val subordinates: MutableList<Employee> = mutableListOf()
)

enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM, // Customer Relationship Manager
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

//2.Создай объекты рабочей группы так, чтобы у CTO был PM и CRM, у PM было два тим-лида (на фронт и бэк) и у каждого
// было по группе сотрудников подходящего для его стека профиля.


fun main() {
    // Сгенерировал данные в ассистенте
    val cto = Employee(
        "Иван Петров",
        true,
        "1980-04-15",
        CharacterTypes.CTO,
        mutableListOf(
            Employee(
                "Мария Сидорова",
                true,
                "1985-08-20",
                CharacterTypes.PM,
                mutableListOf(
                    Employee(
                        "Дмитрий Иванов",
                        true,
                        "1990-03-12",
                        CharacterTypes.TEAM_LEAD,
                        mutableListOf(
                            Employee("Артем Волков", true, "1993-05-18", CharacterTypes.FRONTEND_DEV),
                            Employee("Екатерина Новикова", true, "1994-09-03", CharacterTypes.FRONTEND_DEV),
                            Employee("Сергей Петров", true, "1992-01-22", CharacterTypes.FRONTEND_DEV),
                            Employee("Анна Морозова", true, "1995-12-08", CharacterTypes.QA),
                            Employee("Кристина Егорова", true, "1993-08-15", CharacterTypes.UX_UI)
                        )
                    ),
                    Employee(
                        "Ольга Смирнова",
                        true,
                        "1989-07-25",
                        CharacterTypes.TEAM_LEAD,
                        mutableListOf(
                            Employee("Максим Федоров", true, "1991-06-14", CharacterTypes.BACKEND_DEV),
                            Employee("Наталья Ковалева", true, "1994-04-27", CharacterTypes.BACKEND_DEV),
                            Employee("Павел Орлов", true, "1990-10-19", CharacterTypes.BACKEND_DEV),
                            Employee("Виктор Зайцев", true, "1988-02-11", CharacterTypes.SYSADMIN),
                            Employee("Дарья Белова", true, "1996-03-05", CharacterTypes.QA)
                        )
                    )
                )
            ),
            Employee("Алексей Козлов", true, "1983-11-30", CharacterTypes.CRM)
        )
    )
    // В процессе
}