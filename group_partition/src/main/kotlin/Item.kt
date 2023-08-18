data class Item(val name: String, val type: ItemType)

enum class ItemType{
    STANDARD, PREMIUM, OTHER
}
