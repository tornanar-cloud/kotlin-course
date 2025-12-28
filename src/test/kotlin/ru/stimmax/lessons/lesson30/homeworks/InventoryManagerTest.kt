package ru.stimmax.lessons.lesson30.homeworks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InventoryManagerTest {
/*
    private val iv: InventoryManager = InventoryManager(4)



@Test – указывает, что метод является тестовым.
@BeforeEach / @AfterEach – методы, помеченные этими аннотациями, выполняются до или после каждого теста соответственно.
@BeforeAll / @AfterAll – методы, помеченные этими аннотациями, выполняются один раз до начала всех тестов и после завершения всех тестов класса.

}

  */
private val inventoryManager = InventoryManager(5)

    @Test
    fun getItemCount() = with(inventoryManager) {
        addItem("1", 2)
        assertEquals(2, getItemCount("1"))
    }

    @Test
    fun getItemCountWithMultipleInventory() = with(inventoryManager) {
        addItem("1", 2)
        addItem("2", 1)
        assertEquals(2, getItemCount("1"))
        assertEquals(1, getItemCount("2"))
    }

    @Test
    fun `should return zero if an inventory not exist`() = with(inventoryManager) {
        assertEquals(0, getItemCount("1"))
    }

    @Test
    fun addItem() = with(inventoryManager) {
        addItem("1", 2)
        assertEquals(2, getItemCount("1"))
    }

    @Test
    fun addItems() = with(inventoryManager) {
        addItem("1", 2)
        addItem("2", 1)
        assertEquals(1, getItemCount("2"))
    }

    @Test
    fun fullItems() = with(inventoryManager) {
        addItem("1", 2)
        addItem("2", 3)
        assertEquals(3, getItemCount("2"))
    }

    @Test
    fun `should be thrown when inventory count more than capacity`(): Unit = with(inventoryManager) {
        addItem("1", 2)
        assertThrows(IllegalStateException::class.java) {
            addItem("2", 4)
        }
    }

    @Test
    fun itemShouldBeRemoved() = with(inventoryManager) {
        addItem("1", 2)
        removeItem("1", 2)
        assertEquals(0, getItemCount("1"))
    }

    @Test
    fun removeItemReturnTrueAfterItemRemoved() = with(inventoryManager) {
        addItem("1", 2)
        assertTrue { removeItem("1", 1) }
    }

    @Test
    fun removeItemReturnTrueAfterAllItemsRemoved() = with(inventoryManager) {
        addItem("1", 2)
        assertTrue { removeItem("1", 2) }
    }

    @Test
    fun itemNotRemovedIfItNotExist() = with(inventoryManager) {
        assertFalse { removeItem("1", 1) }
    }

    @Test
    fun itemNotRemovedIfInventoryQuantityLowerThanRemoving() = with(inventoryManager) {
        addItem("1", 1)
        assertFalse { removeItem("1", 2) }
    }

    @Test
    fun removeItemsPartially() = with(inventoryManager) {
        addItem("1", 5)
        removeItem("1", 2)
        assertEquals(3, getItemCount("1"))
    }
}
