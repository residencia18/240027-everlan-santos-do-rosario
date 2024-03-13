//package com.ever.suinocutura.model.user;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity(name = "users")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Usuario implements UserDetails{
//		
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private String login;
//	
//	private String password;
//	
//	private UserRole role;
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		if(this.role == UserRole.ADMIN) {
//			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
//		}else {
//			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//		}
//	}
//
//	@Override
//	public String getPassword() {
//		return this.password;
//	}
//
//	@Override
//	public String getUsername() {
//		return this.login;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//	
//	
//}
