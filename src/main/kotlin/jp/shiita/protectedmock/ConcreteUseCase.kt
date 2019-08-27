package jp.shiita.protectedmock

data class ResultData(val data1: Int, val data2: String)

class ConcreteUseCase(
    private val repository1: Repository1,
    private val repository2: Repository2
) : UseCase<Int, ResultData>() {

    // protectedなのでモック出来ない
    override fun execute(parameters: Int): ResultData {
        val data1 = repository1.loadData(parameters)
        val data2 = repository2.loadData(parameters)
        return ResultData(data1, data2)
    }
}