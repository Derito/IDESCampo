package org.helderito.idescampo.domain.service;


import lombok.RequiredArgsConstructor;
import org.helderito.idescampo.domain.model.Usuario;
import org.helderito.idescampo.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
     Usuario uso =  Optional.ofNullable(usuarioRepository.findByNomeUsuario(nomeUsuario)).orElseThrow(()->
               new UsernameNotFoundException("User not found!"));

        List<GrantedAuthority> adminsAuthorityList = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
        List<GrantedAuthority> usersAuthorityList = AuthorityUtils.createAuthorityList("ROLE_USER");

        return  new org.springframework.security.core.userdetails.User(uso.getNomeUsuario(),uso.getSenha(),uso.isAdmin() ? adminsAuthorityList : usersAuthorityList);    }
}
