interface CRUDService<T> {
    fun add(item: T)
    fun getById(id: Int): T
    fun edit(id: Int, item: T)
    fun delete(id: Int)
}