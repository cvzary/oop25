import java.util.*;

public class Family {
    private final Map<String, List<Person>> family;

    public Family() {
        this.family = new HashMap<>();
    }

    public void add(Person ... people) {
        for(Person p : people) {
            String key = p.getFullName();
            if(!family.containsKey(p.getFullName())) {
                family.put(key, new ArrayList<>());
            }
            family.get(key).add(p);
        }
    }

    public List<Person> get(String key) {
        //        List<Person> members = family.getOrDefault(key, new ArrayList<>());
        //         System.out.println("przed sortowaniem: "+members);
        //            Collections.sort(members);
        return family.getOrDefault(key, new ArrayList<>())
                .stream()
                .sorted()
                .toList();
    }
}
