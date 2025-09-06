package injinrithm._2_st_week

class _02_02_append_linked_list {
}


class Node(
    var data: Int,
    var next: Node? = null,
)

class LinkedListIJ {
    private var head: Node? = null
    private var tail: Node? = null

    // 끝에 노드 추가: O(1)
    fun append(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
    }

    // 앞에 노드 추가: O(1)
    fun prepend(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
    }

    // index 위치에 노드 삽입: O(n)
    fun addToIndex(index: Int, data: Int) {
        if (index < 0) return
        
        // index 0: head 앞에 삽입
        if (index == 0) {
            prepend(data)
            return
        }
        
        // 이전 노드 찾기
        val prevNode = getNode(index - 1) ?: return
        val newNode = Node(data, prevNode.next)
        prevNode.next = newNode
        
        // tail 업데이트
        if (prevNode == tail) {
            tail = newNode
        }
    }

    // index로 노드 삭제: O(n)
    fun delete(index: Int) {
        if (index < 0 || head == null) return

        // 1. head 삭제 (index = 0)
        if (index == 0) {
            head = head?.next
            if (head == null) tail = null
            return
        }

        // 2. 이전 노드 찾기
        val prevNode = getNode(index - 1) ?: return
        val nodeToDelete = prevNode.next ?: return

        // 3. 연결 변경
        prevNode.next = nodeToDelete.next

        // 4. 삭제된 노드 정리
        nodeToDelete.next = null

        // 5. tail 업데이트
        if (nodeToDelete == tail) {
            tail = prevNode
        }
    }

    // index로 노드 가져오기: O(n)
    fun getNode(index: Int): Node? {
        if (index < 0) return null

        var current = head
        var currentIndex = 0

        while (current != null) {
            if (currentIndex == index) return current
            current = current.next
            currentIndex++
        }
        return null
    }

    // index로 데이터 가져오기: O(n)
    fun get(index: Int): Int? {
        return getNode(index)?.data
    }

    // 모든 노드 출력
    fun printList() {
        var currentNode = head
        while (currentNode != null) {
            print("${currentNode.data} -> ")
            currentNode = currentNode.next
        }
        println("null")
    }
}
