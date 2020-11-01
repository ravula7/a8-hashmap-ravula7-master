package a8;

import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "YOUR PASSWORD HERE";
    private Account[] _passwords;
    public PasswordManager() {
       // Account[]
         _passwords = new Account[50]; //array of type account --> can use all account methods
    }


    // TODO: put
    /**
     * Creates an Account object using the key value pair,
     * and inserts the object at the appropriate index
     * based on the hash of they key. If the key already
     * exists in map, update its value.
     * @param key: the website name
     * @param value: the password
     */
    @Override
    public void put(K key, V value) {
        Account<K,V> account = new Account<>(key,value); //creates an account object using the passed key value pair

        //calculate hash function to find the appropriate index
        int hashKey = Math.abs(key.hashCode()) % 50; //want to insert account at this index

        while(_passwords[hashKey] != null) { //when the hashKey has non-empty linked list
            if(_passwords[hashKey].equals(key)) { //if key already exists, update the value
                Account temp = _passwords[hashKey];
                temp = temp.getNext();
            }
            else { //if key doesn't exist, then add the account to the end of the list
                _passwords[hashKey] = account;
            }
        }

/*

        if(_passwords[hashKey] != null) { //when the hashKey has non-empty linked list
            if(_passwords[hashKey].equals(key)) { //if key already exists, update the value
                Account temp = _passwords[hashKey];
                temp = temp.getNext();
            }
            else { //if key doesn't exist, then add the account to the end of the list
                _passwords[hashKey] = account;
            }
        }
        else {
            LinkedList emptyList = new LinkedList();
            emptyList.add(account);
            _passwords[hashKey] = emptyList;
        }

























        LinkedList <K> list = new LinkedList<K>();
        //insert the account at index
        while(_passwords != null) {
            if(_passwords.equals(key)) {
                _passwords.next = value;
            }


        i++;
        }
                //_passwords != null){


            //.equals(key)){

            }

        }





        int i=0;
        //while(i<_passwords.length){
        while(index < _passwords.length){
            //if key exists in the map, keep the key and update the value
            if(list.contains(key)){

            }
            //if key doesn't exist in the map, insert the object (key and value at the index)
            else{
                _passwords[index] = account;
            }
            i++;
        }



        //if at the index, there is nothing --> create a new linked list and add the account
        //if at the index, there is already something --> check if that key is the same as passed key
            //if yes, update the value
            //if no, add the account to the end of the linked list







       // Account temp = _passwords[hashKey];
        //temp = temp.getNext();


        LinkedList <K,V> list = new LinkedList<K,V>();
        Account temp = _passwords[hashKey];

        //there is one linked list at each index
        //check each index to see if the key is there






        int i =0;
        while(i < list.indexOf(index).size()){
            if(list.contains(key)){

            }
            else{

            }

                    i++;
        }

 */

    }

    // TODO: get
    @Override
    public V get(K key) {
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        return 0;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        return null;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        return null;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        return null;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return false;
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
