
interface PersonalCount{
    val  personalCount: Int
}


class Department(val name: String): PersonalCount {

    private val employees = mutableSetOf<Employee>()

    override val personalCount: Int
        get() {
            return employees.size
        }

    fun addEmployee(employee: Employee) = employees.add(employee)
    fun removeEmployee(employee: Employee) = employees.remove(employee)

}