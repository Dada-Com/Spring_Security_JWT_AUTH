import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import com.jpa.test.entity.UserModel;
public class Custom_CoreJAVA_Configuration {
//  
//  User user1 = new User();
//  user1.setName("Ram");
//  user1.setUsername("Ram");
//  user1.setPassword("1234");
//  user1.setWork("Clerk");
//  
//  User res = userrepo.save(user1);
//  System.out.println(res);
  
//  User user2 = new User();
//  user2.setName("Sham");
//  user2.setUsername("Sham");
//  user2.setPassword("1234");
//  user2.setWork("Officer");
//  
//  User user3 = new User();
//  user3.setName("Viraj");
//  user3.setUsername("viraj");
//  user3.setPassword("1234");
//  user3.setWork("Peon");
//  
//  List<User> users = List.of(user2,user3);
//  Iterable<User> res1 =  userrepo.saveAll(users);
//   
//  res1.forEach(user->{
//     System.out.println(user);
//  });
//  
//  System.out.println("Done");
  /*
  // update the user of id 3
  Optional<User> optional = userrepo.findById(3);
  
  User user = optional.get();
  user.setName("Hari");
  User resupd = userrepo.save(user);
  System.out.println(resupd); 
  
  // print all user
  Iterable<User> itr = userrepo.findAll();
  Iterator<User> iterator = itr.iterator();
  while(iterator.hasNext()) {
  	User user = iterator.next();
  	System.out.println(user);
  }
  
  Iterable<User> itr = userrepo.findAll();
  itr.forEach(user->{
      System.out.println(user);
		
	});*/
  // Deleting User element
//  userrepo.deleteById(3);
//  System.out.println("Deleted");
//  Iterable<User> alluser = userrepo.findAll();
//  alluser.forEach(user -> System.out.println(user));
//  userrepo.deleteAll(alluser);
 //Native Query 
//  List<User> user = userrepo.getAllUserNative();
//  user.forEach(users-> {
//  	System.out.println(users);
//  });
}
