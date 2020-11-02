package a8;

import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "YOUR PASSWORD HERE";
    private Account[] _passwords;
    public PasswordManager() {
       // Account[]
         _passwords = new Account[50]; //array of account type --> can use all account methods
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
        int hashKey = Math.abs(key.hashCode() % 50); //calculate hashKey (to place account at this index)
        if (_passwords[hashKey] == null) {  //if there is nothing at the hashKey,
            _passwords[hashKey] = new Account(key, value); //create a new node
        }

        else { //else - there is something at the hashKey
            Account temp = _passwords[hashKey]; //use temp account object so you are not overwriting whatever data is in the array at that hashKey
            //use a while loop to traverse all entries until there is _next == null for an account meaning we have reached the end
            while (temp.getNext() != null) {
                //if the key matches the account's key, update the value - password being updated for a website
                if (temp.getWebsite().equals(key)) {
                    temp.setPassword(value);
                }
                //else - chain to the tail
                else {
                    temp.setNext(new Account(key, value));
                    //temp = temp.getNext();
                    // Account temp = new Account(key, value);
                }
                _passwords[hashKey] = temp;
            }
        }

/*
            //use a while loop through go through all the entries until both the conditions are false - that way you are able to traverse through every single entry that is at the index
            //first condition is when the account's _next isn't null - it is pointing to another node, so there is something after that
            //second condition is when the account's key doesn't equal the key passed
            while (account.getNext() != null && !account.getWebsite().equals(key))
                account = account.getNext();
                if (account.getWebsite().equals(key)) {
                    account.setPassword(value);
                } else
                    account.setNext(new Account(key, value));
            }
        }

        /*else {
            while(_passwords[hashKey] != null) {

            }


        }



    }

    Account account = new Account(key,value); //first node has been created

account.setWebsite(key);
            account.setPassword(value);
            account.setNext(null);
    _passwords[hashKey] = account;















        int index = Math.abs(key.hashCode() % 50); //hash is calculated
        Account items = _passwords[index]; //set that index in _passwords array as Account of items - could be empty or non-empty accounts

        if(items == null) { //if there is nothing at the index (no accounts exist)
            items = new Account(key,value); //create a new node/account object there

            Account item = new Account(key,value); //a temporary account to store the new account object

            items.setNext(item); //set the next as

            _passwords[index] = items;
        }
        else {
            while(_passwords[index]!=null) {
                if(_passwords[index].equals(key)) {
                    _passwords[index] = items;

                }
            }

            Account item = new Account(key,value);

            items.setNext(item);
        }








        //calculate hash function to find the appropriate index
        int hashKey = Math.abs(key.hashCode()) % 50; //want to insert account at this index
        Account accounts = _passwords[hashKey]; //created a node at the hashKey
        //new Account<>(key,value); //creates an account object using the passed key value pair

        if(accounts == null){
            accounts = new Account <K,V> (key,value);

            Account account = new Account(key,value);

            accounts.setNext(account);
            _passwords[hashKey] = accounts;
        }
        else{
            for(Account account: accounts){

            }
        }


















        if(_passwords[hashKey] == null){ //when the hashKey has empty linked list
            _passwords[hashKey] = account;
        }
        else {
            while (_passwords[hashKey] != null) { //when the hashKey has non-empty linked list - run through it - traverse the list

                if (_passwords[hashKey].equals(key)) { //if key already exists, update the value


                    Account temp = _passwords[hashKey]; //store whatever is at the key already to temp

                    temp.setNext(account);
                } else { //if key doesn't exist, then add the account to the end of the list

                }
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
    /**
     * Returns the value associated with the given key.
     * This operation should have O(1) runtime.
     * If the key is not in the array, return null.
     * @param key
     * @return the value (password) associated with that key
     */
    @Override
    public V get(K key) {
        for(int i = 0; i<_passwords.length; i++){
            if((K) _passwords[i] == key) {
                return (V) _passwords[i];
            }
        }
        return null;
    }
    /**
     * Returns the number of key-value mappings in the map.
     * @return the number of accounts in the map.
     */
    // TODO: size
    @Override
    public int size() {
        for(int i = 0; i<_passwords.length;i++){


        }


        return 0;
    }
    /**
     * Returns a Set of all the keys (websites) contained in this map.
     *
     * @return A set of the keys contained in the map
     */
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
