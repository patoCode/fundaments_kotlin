
fun main(args: Array<String>) {
    val items = listOf(
        Item(name = "Item #1", type = ItemType.STANDARD),
        Item(name = "Item #2", type = ItemType.OTHER),
        Item(name = "Item #3", type = ItemType.PREMIUM),
        Item(name = "Item #4", type = ItemType.STANDARD),
        Item(name = "Item #5", type = ItemType.PREMIUM)
    )

    /*****************************************************/
    /************      1. SIMPLE GROUP BY      ***********/
    /*****************************************************/
    val groupedByItems = items.groupBy { it.type }
    println(groupedByItems)
    // OUTPUT: {
        //  STANDARD=[Item(name=Item #1, type=STANDARD), Item(name=Item #4, type=STANDARD)],
        //  OTHER=[Item(name=Item #2, type=OTHER)],
        //  PREMIUM=[Item(name=Item #3, type=PREMIUM), Item(name=Item #5, type=PREMIUM)]
    //  }

    /*****************************************************/
    /************ 2. Transformacion de valores ***********/
    /*****************************************************/
    val groupedByItemsNamesOnly = items.groupBy(
        (Item::type),
        (Item::name)
    )
    println(groupedByItemsNamesOnly)
    // OUTPUT : {
        //  STANDARD=[Item #1, Item #4],
        //  OTHER=[Item #2],
        //  PREMIUM=[Item #3, Item #5]
    // }

    /*****************************************************/
    /*************** 3. Partition Simple   ***************/
    /*****************************************************/
    val partitioned = items.partition { it.type == ItemType.PREMIUM }
    println("Premium: ${partitioned.first}")
    println("Other types: ${partitioned.second}")
}