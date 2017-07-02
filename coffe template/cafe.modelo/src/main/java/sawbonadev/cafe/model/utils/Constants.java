/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model.utils;

/**
 *
 * @author sawbona
 */
public final class Constants {
    
    public enum ACTIVITY_STATUS{
        
        NEW(1, "NEW");
        
        private ACTIVITY_STATUS(long id, String description){
            this.id = id;
            this.description = description;
        }
        
        private final long id;
        private final String description;
        
        public long getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }
    }
    
}
