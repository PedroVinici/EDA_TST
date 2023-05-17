package Questoes;

import java.util.Arrays;
import java.util.Scanner;

public class HashSet {
    Integer[] table;
    int capacity;

    public HashSet(int capacity){
        this.table = new Integer[capacity];
        this.capacity = capacity;
    }

    public int hash(int key, int sondagem){
        return (key + sondagem) % this.capacity;
    }

    public void insert(int value){
        int sondagem = 0;
        if(this.contains(value)){
            return;
        }
        while(sondagem < table.length){
            int hash = hash(value, sondagem);
            if(table[hash] == null){
                table[hash] = value;
                return;
            }
            sondagem ++;
        }        
    }

    public void remove(int value){
        int sondagem = 0;

        while(sondagem < table.length){
            int posicao = hash(value, sondagem);
            if(table[posicao] != null){
                if(table[posicao].equals(value)){
                    table[posicao] = null;
                }
            }
            sondagem++;
        }
    }   

    public boolean contains(int value){
        int sondagem = 0;
        
        while(sondagem < table.length){
            int posicao = hash(value, sondagem);
            if(table[posicao]!= null){
                if(table[posicao].equals(value)){
                    return true;
                }
            }
            sondagem ++;
        }
        return false;
    }

    public String toString(){
        return Arrays.toString(table);
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String size = sc.nextLine();
        HashSet hashSet = new HashSet(Integer.parseInt(size));
        while(true){
            String[] comando = sc.nextLine().split(" ");
            switch (comando[0]) {
                case "put":
                    hashSet.insert(Integer.parseInt(comando[1]));
                    System.out.println(hashSet.toString());
                    break;
                case "remove":
                    hashSet.remove(Integer.parseInt(comando[1]));
                    System.out.println(hashSet.toString());
                    break;
                case "contains":
                    Boolean a = hashSet.contains(Integer.parseInt(comando[1]));
                    System.out.println(a);
                    break;
                default:
                    return;
            }
        }
        
    }
}

