package org.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* Необходимо реализовать метод разворота связного списка
        *  (двухсвязного или односвязного на выбор).
        */
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("");
        System.out.println("---------");
        head = reverseList(head);
        ListNode current2 = head;
        while (current2 != null) {
            System.out.print(current2.val + " ");
            current2 = current2.next;
        }
        System.out.println("");
        System.out.println("");
        //  Имеется список целых чисел. Продублировать в нем все четные числа
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println("Исходный список: " + myList);
        duplicateEven(myList);
        System.out.println("Список после дублирования четных чисел: " + myList);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void duplicateEven(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) % 2 == 0) {
                list.add(i + 1, list.get(i));
                size++; // увеличиваем размер списка на 1, чтобы не посмотреть последний добавленный элемент.
                i++; // пропускаем следующее число, чтобы не продублировать его еще раз.
            }
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}