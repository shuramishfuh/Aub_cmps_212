package com.HW7;

import java.util.ArrayList;

public class AssassinManager {
    AssassinNode killRing;
    AssassinNode graveyard;

    /**
     * constructor
     * Build linkedlist from array of list of names
     * @param names array, lis of names
     */
    public AssassinManager(ArrayList<String> names){
        if(names.size() != 0 || names != null) {
            names.forEach((n)->{
                if (killRing == null){ killRing =new AssassinNode(n) ; }
                else{  AssassinNode current = killRing;
                    while (current.next !=null){
                            current = current.next;
                      }
                    current.next = new AssassinNode(n);
                }
            });
        }
        else { throw new IllegalArgumentException(" List cannot be null or empty");}

    }

    /**
     * check if the game is over by checking if there is more than one player left
     * @return boolean, true if one player left false otherwise
     */
    public boolean isGameOver(){
        if (killRing.next ==null) return true;
        else return false;
    }

    /**
     * print all players that have been killed including the names of the players that
     * killed them
     */
    public void printGraveyard() {
        if (graveyard == null)
            System.out.println(" No one has been killed yet");
        else {
            AssassinNode current = graveyard;
            while (current != null) {
                System.out.println("  " + current.name + " was killed by " + current.killer);
                current = current.next;
            }
        }
    }

    /**
     * returns name of winner if game has ended or null
     * @return  String or null
     */
    public String winner(){
        if (isGameOver()) return killRing.name;
        else return null;
    }

    /**
     *  add killed player to the graveyard
     * @param node AssassinNode,  player to be added to graveyard
     */
    public void addGraveYard(AssassinNode node){
        if (graveyard != null) {
            node.next = graveyard;
            graveyard = node;
        }
        graveyard = node;
    }

    /**
     * print all active participants in order name is stalking next name in the list
     */
    public void printKillRing(){
        if(killRing.next == null || killRing == null)
            System.out.println(" there is either one or no player left in the game thence no kill-ring");
        else {
            AssassinNode first = killRing;
            AssassinNode current = killRing;
            while (current.next !=null){
                System.out.println("  "+ current.name + " is stalking " +current.next.name );
                current= current.next;
            }
            System.out.println("  "+ current.name + " is stalking " +first.name);
        }

        System.out.println(); // padding btm
    }

    /**
     * checks if the graveyard contains @param name ignoring adjacent nodes to the current
     *because that is the player who killed current
     * @param name dead player name
     * @return  boolean true if found otherwise false
     */
    public boolean graveyardContains(String name){
        if(graveyard != null ){
            AssassinNode current = graveyard;
            while (current !=null){
                if (current.name.equalsIgnoreCase(name))return true;
                current= current.next;
            }
        }
        return false;
    }

    /**
     * find if player is still in the game
     * @param name player name
     * @return boolean, true if player is still playing else false
     */
    public boolean killRingContains(String name){
        if(killRing != null){
            AssassinNode current = killRing;
            while (current != null){
                if (current.name.equalsIgnoreCase(name)) return true;
                current = current.next;
            }
        }
        return false;
    }

    public void kill(String name){
            if (!killRingContains(name)) throw  new IllegalArgumentException("no such player");
            else if (isGameOver()) throw new IllegalStateException("game has ended");
            else if(killRing.next ==null) throw new IllegalStateException("cant remove the winner");
            else {
                AssassinNode current  = killRing;
                AssassinNode pre = killRing;
                while (current != null){
                    if (current.name.equalsIgnoreCase(name)){
                        if (current == killRing){ // first player in list
                            AssassinNode node = current;
                            while (current.next != null){ // get last player
                                current= current.next;
                            }
                            node.killer = current.name;
                            killRing =killRing.next;
                            node.next = null;
                            addGraveYard(node);
                        }
                        else { // any other node
                          current.killer = pre.name;


                          if (current.next == null){
                              pre.next = null;
                          }
                          else pre.next = current.next;
                          current.next=null;
                            addGraveYard(current);
                        }
                        break;

                    }
                    pre = current;
                    current = current.next;
                }
            }
    }
}
