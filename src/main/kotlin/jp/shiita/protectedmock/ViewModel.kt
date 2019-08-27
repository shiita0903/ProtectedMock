package jp.shiita.protectedmock

class ViewModel(
    private val id: Int,
    private val concreteUseCase: ConcreteUseCase
) {
    fun loadData(): String {
        val resultData = concreteUseCase(id)
        return "${resultData.data1}:${resultData.data2}"
    }
}