package com.bp.lisovyj.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class PhoneBook {
    static class Contact implements Comparable<Contact>{
        private String name;
        private LocalDate dateOfBirth;
        private TreeSet<String> phones;
        private String addres;
        private LocalDateTime dateChanges;

        public Contact() {
            this.phones = new TreeSet<>();
        }

        public Contact(String name, LocalDate dateOfBirth, TreeSet<String> phones, String addres, LocalDateTime dateChanges) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.phones = phones;
            this.addres = addres;
            this.dateChanges = dateChanges;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public TreeSet<String> getPhones() {
            return phones;
        }

        public void setPhones(TreeSet<String> phones) {
            this.phones = phones;
        }

        public String getAddres() {
            return addres;
        }

        public void setAddres(String addres) {
            this.addres = addres;
        }

        public LocalDateTime getDateChanges() {
            return dateChanges;
        }

        public void setDateChanges(LocalDateTime dateChanges) {
            this.dateChanges = dateChanges;
        }

        public void addPhone(String phone){
            phones.add(phone);
        }

        public void addPhones(Collection<String> list){
            phones.addAll(list);
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    ", phones=" + phones +
                    ", addres='" + addres + '\'' +
                    ", dateChanges=" + dateChanges +
                    '}';
        }

        @Override
        public int compareTo(Contact contact) {
            return 0;
        }
    }
    private static ObjectMapper mapper;
    private List<Contact> list;

    public PhoneBook(){
        list = new ArrayList<>();
    }

    public List<Contact> getList() {
        return list;
    }

    public void setList(List<Contact> list) {
        this.list = list;
    }

    public void addContact(Contact contact){
        list.add(contact);
    }

    public Contact getContact(int i){
        if(i >= list.size() || i < 0){
            throw new RuntimeException("Такого контакту не існує");
        }
        return list.get(i);
    }

    public int find(String name){
        int i;
        for(i = 0; i < list.size(); i++){
            if(name.equals(list.get(i).name)){
                return i;
            }
        }
        return -1;
    }

    public void sortByName(){
        List<Contact> mas = new ArrayList<>(list);
        mas.sort(Comparator.comparing(c -> c.name));
        mas.forEach(c -> System.out.println(c.toString()));
    }

    public void sortByAge(){
        List<Contact> mas = new ArrayList<>(list);
        mas.sort(Comparator.comparing(c -> c.dateOfBirth));
        mas.forEach(c -> System.out.println(c.toString()));
    }

    public void changeContact(int index, Contact contact){
        if(index >= list.size() || index < 0){
            throw new RuntimeException("Такого контакту не існує");
        }
        Contact cc = list.get(index);
        boolean change = false;
        if(!contact.getName().equals(cc.name)){
            cc.setName(contact.name);
            change = true;
        }
        if(!contact.getDateOfBirth().equals(cc.dateOfBirth)){
            cc.setDateOfBirth(contact.dateOfBirth);
            change = true;
        }
        if(!contact.getPhones().equals(cc.getPhones())){
            cc.setPhones(contact.getPhones());
            change = true;
        }
        if(!contact.getAddres().equals(cc.getAddres())){
            cc.setAddres(contact.getAddres());
            change = true;
        }
        if(change){
            cc.setDateChanges(LocalDateTime.now());
        }
    }

    private static void initMapper(){
        mapper = new ObjectMapper();
        SimpleModule mod = new SimpleModule();
        mod.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        mod.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mod.addSerializer(LocalDate.class, new LocalDateSerializer());
        mod.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(mod);
    }

    public static void toJson(String file, Object ob){
        if(mapper == null){
            initMapper();
        }
        try {
            mapper.writeValue(new File(file), ob);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PhoneBook fromJson(String file){
        if(mapper == null){
            initMapper();
        }
        try {
            return mapper.readValue(new File(file), PhoneBook.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.addContact(new Contact("Віктор", LocalDate.of(1993, 2, 3), new TreeSet<>(Arrays.asList("380939328243")), "myAddres", LocalDateTime.now()));
        pb.addContact(new Contact("Ельвіра", LocalDate.of(2001, 1, 12), new TreeSet<>(Arrays.asList("123456")), "NotmyAddres", LocalDateTime.now()));
        pb.addContact(new Contact("Андрій", LocalDate.of(1989, 11, 22), new TreeSet<>(Arrays.asList("7654321")), "anohermyAddres", LocalDateTime.now()));
        pb.sortByName();
        System.out.println("##################");
        PhoneBook.toJson("files/PB2.json", pb);

        PhoneBook pb2 = PhoneBook.fromJson("files/PB2.json");
        assert pb2 != null;
        pb2.sortByAge();
        pb2.changeContact(0, new Contact("Дима", LocalDate.of(2001,1,24),new TreeSet<>(Arrays.asList("3801234567")), "mymyAdres", LocalDateTime.now()));
        System.out.println("##################");
        pb2.sortByName();
    }
}
