lateinit var api: UserApi
lateinit var repository: UserRepositoryImp
lateinit var userViewModel: UserViewModel

fun main(args: Array<String>) {

    api = UserApi()
    repository = UserRepositoryImp(api)
    userViewModel = UserViewModel(repository)

    println(userViewModel.getAllUserInformation(userId = 1230))
}