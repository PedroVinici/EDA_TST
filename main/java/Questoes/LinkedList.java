package Questoes;
import java.*;
import java.util.Scanner;
public class LinkedList {
    Node head;
    Node tail;

    public boolean isEmpty(){
        return head == null;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            newNode.previous = tail;
            this.tail = newNode;
        }
    }

    public void trim(){
        if(!isEmpty()){
            if(this.head.next == null){
                head = null;
                tail = null;
            }else{
                this.tail = tail.previous;
                this.tail.next = null;
                if(this.head.next == null){
                    head = null;
                    tail = null; 
                }else{
                    this.head = this.head.next;
                    this.head.previous = null;
                }
            }
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
        int data;
        Node next;
        Node previous;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
   
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        for(int i=0; i < values.length; i++){
            list.addLast(Integer.parseInt(values[i]));
        }
        int remover = sc.nextInt();
        while(remover!=0){
            list.trim();
            remover -= 1;
        }
        System.out.println(list.toString().trim());
    }
}
