package br.com.bluesoft.desafiov3.desafiov3.pedido.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.*;

import br.com.bluesoft.desafiov3.desafiov3.pedido.model.Pedido;

@Repository
public class PedidoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Pedido salvarPedido(Pedido pedido) {
        entityManager.persist(pedido);
        return pedido;
    }


    public List<Pedido> listarTodos(){
        String sql = "select * from pedidos";

        final Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }

    public Pedido buscarPedido(Long pedidoId) {
        String sql = " from Pedido p where p.id = :pedidoId ";

        final Query query = entityManager.createQuery(sql);

        query.setParameter("pedidoId", pedidoId);
        try {
            return (Pedido) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Transactional
    public void deletarPedido(Pedido pedido) {
        entityManager.remove(pedido);
    }

}
