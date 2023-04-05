interface UserRepository {

    fun getUserInformation(userId: Int): User?

}