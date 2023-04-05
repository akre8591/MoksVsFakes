class FakeUserRepository : UserRepository {

    var user: User? = null

    override fun getUserInformation(userId: Int): User? {
        return user
    }
}