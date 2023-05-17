package Questoes;

import java.util.Scanner;

public class Filter {
    Node head;
    Node tail;

    public boolean isEmpty(){
        return this.head == null;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    public void removeByIndex(int valor){
        Node aux = head;
        while(aux != null){
            if(aux.data == valor){
                if(this.head.next == null){
                    this.head = null;
                    this.tail = null;
                }
                else if(aux.previous == null){
                    this.head = this.head.next;
                    this.head.previous = null;
                }
                else if(aux.next == null){
                    this.tail = this.tail.previous;
                    this.tail.next = null;
                }
                else{
                    aux.previous.next = aux.next;
                    aux.next.previous = aux.previous;
                }
            }
            aux = aux.next;
        }
    }

    public String toString(){
        if(isEmpty()){
            return "vazia";
        }
        String str = " ";
        Node aux = head;
        while(aux != null){
            str += String.valueOf(aux.data) + " ";
            aux = aux.next;
        }
        return str;
    }

    public class Node{
        protected int data;
        protected Node next;
        protected Node previous;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    public static void main(String[] args) {
        Filter list = new Filter();
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        for(int i =0; i < values.length; i++){
            list.addLast(Integer.parseInt(values[i]));
        }
        list.removeByIndex(sc.nextInt());
        System.out.println(list.toString().trim());
    }
}
