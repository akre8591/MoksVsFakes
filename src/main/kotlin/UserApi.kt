class UserApi {

    private val listOfUsers = listOf(
        User(1230, "Diego", "Casas", 32, Gender.Male),
        User(1231, "Karen", "Wright", 25, null),
        User(1232, "Lynda", "Smith", 20, Gender.Female),
        User(1233, "Bradley", "Johnson", 44, Gender.Male),
        User(1234, "Adam", "Williams", 34, Gender.Male),
        User(1235, "Paul", "Brown", 58, Gender.Male),
        User(1236, "Sophia", "Jones", 28, Gender.Female),
        User(1237, "Aaron", "Garcia", 23, Gender.Male),
        User(1238, "Emma", "Miller", 32, Gender.Female),
        User(1239, "Walter", "White", null, Gender.Male),
        User(1240, "Drake", "Davis", 45, Gender.Male),
        User(1241, "Marshall", "Anderson", 38, Gender.Male),
        User(1242, "Selena", "Lewis", 27, Gender.Female),
        User(1243, "Laurence", "Thomas", 22, Gender.Female),
        User(1244, "Olivia", "Wilson", 42, Gender.Female),
        User(1245, "Bob", "Clark", 30, Gender.Male),
    )

    fun fetchUserById(userId: Int): User? {
        return listOfUsers.firstOrNull { user ->
            user.id == userId
        }
    }

}