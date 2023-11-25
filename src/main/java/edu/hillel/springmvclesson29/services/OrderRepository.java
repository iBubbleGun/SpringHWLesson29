package edu.hillel.springmvclesson29.services;

import edu.hillel.springmvclesson29.dao.OrderDAO;
import edu.hillel.springmvclesson29.exceptions.OrderNotFoundException;
import edu.hillel.springmvclesson29.model.Order;
import edu.hillel.springmvclesson29.response.ResponseBodyInterface;
import edu.hillel.springmvclesson29.response.body.ErrorBody;
import edu.hillel.springmvclesson29.response.body.InfoBody;
import edu.hillel.springmvclesson29.response.body.WarnBody;
import edu.hillel.springmvclesson29.response.enums.ErrorCode;
import edu.hillel.springmvclesson29.response.enums.InfoCode;
import edu.hillel.springmvclesson29.response.enums.WarnCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderRepository {

    private final Map<Integer, Order> orders = OrderDAO.orderDAO.getInitialOrders();

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public Order getOrder(int id) {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        throw new OrderNotFoundException(id);
    }

    public ResponseEntity<ResponseBodyInterface> addOrder(@NotNull Order order) {
        final int id = order.getId();
        if (!orders.containsKey(id)) {
            orders.put(id, order);
            if (orders.containsKey(id)) {
                return new ResponseEntity<>(new InfoBody(InfoCode.ORDER_ADD_OK, "New order with id=\"" + id + "\" successfully added."), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ErrorBody(ErrorCode.ORDER_ADD_ERROR, "Internal server error. Please, try again."), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(new WarnBody(WarnCode.ORDER_ADD_WARN, "Order with id=\"" + id + "\" already exist!"), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseBodyInterface> removeOrder(int id) {
        if (orders.containsKey(id)) {
            orders.remove(id);
            if (!orders.containsKey(id)) {
                return new ResponseEntity<>(new InfoBody(InfoCode.ORDER_REMOVE_OK, "Order with id=\"" + id + "\" successfully removed."), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ErrorBody(ErrorCode.ORDER_REMOVE_ERROR, "Internal server error. Please, try again."), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(new WarnBody(WarnCode.ORDER_REMOVE_WARN, "Order with id=\"" + id + "\" not found!"), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseBodyInterface> removeOrder(@NotNull Order order) {
        return removeOrder(order.getId());
    }
}
