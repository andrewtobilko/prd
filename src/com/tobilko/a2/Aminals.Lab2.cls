Class Animals.Lab2
{

    /*

    Спроектувати глобал так, щоб у нього було принаймні 4 індекси, хоча б трьох різних типів.
    Використати в якості значень вузлів глобала 2 різних види списків (строковий та $LB).
    Показати використання принаймні 4 різних функцій роботи з глобалами (масивами).
    Усі параметри повинні вводитися з клавіатури, а не жорстко кодуватися в програмі.
    Глобал і функції роботи з ним повинні мати сенс.

    */
    ClassMethod Task()
    {
        read "Enter value", name, !
    }

    ClassMethod PopulateGlobal()
    {
        // ^Animals(section) = section description
        // ^Animals(section, animal) = number
        // ^Animals(section, "popularNames") = name list

        set ^Animals("section1") = "section 1 comprises lions and cheetahs"
        set ^Animals("section1", "lion") = 5
        set ^Animals("section1", "cheetah") = 7
        set ^Animals("section1", "popularNames") = $lb("James", "Harry", "Ann", "Richard")

        set ^Animals("section2") = "section 2 collects some monkeys"
        set ^Animals("section2", "chimpanzee") = 2
        set ^Animals("section2", "gibbon") = 5
        set ^Animals("section2", "popularNames") = "Ann/John/Katy/William"

        set ^Animals("title") = "Animal Park"
        set ^Animals("area")  = "25 square miles"
    }

    ClassMethod PrintGeneralInformation()
    {

    }

}