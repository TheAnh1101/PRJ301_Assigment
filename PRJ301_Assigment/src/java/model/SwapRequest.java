/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AD
 */
public class SwapRequest {
    private int id;
    private int sender_id;
    private int receiver_id;
    private int current_cid_sender;
    private int current_cid_receiver;
    private String mess;
    private String status;

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public int getCurrent_cid_sender() {
        return current_cid_sender;
    }

    public void setCurrent_cid_sender(int current_cid_sender) {
        this.current_cid_sender = current_cid_sender;
    }

    public int getCurrent_cid_receiver() {
        return current_cid_receiver;
    }

    public void setCurrent_cid_receiver(int current_cid_receiver) {
        this.current_cid_receiver = current_cid_receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
