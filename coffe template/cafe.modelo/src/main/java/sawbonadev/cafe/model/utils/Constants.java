/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model.utils;

import sawbonadev.cafe.model.projects.ActivityStatus;

/**
 *
 * @author sawbona
 */
public final class Constants {

    public enum ACTIVITY_STATUS {

        NEW(1, "NEW"),
        IN_PROGRES(2, "IN PROGRESS"),
        COMPLETED(3, "COMPLETED");

        private ACTIVITY_STATUS(long id, String description) {
            this.id = id;
            this.description = description;
        }

        public static ACTIVITY_STATUS getStatusEnumById(long id) {
            for (ACTIVITY_STATUS value : ACTIVITY_STATUS.values()) {
                if (value.getId() == id) {
                    return value;
                }
            }
            return null;
        }

        public static ActivityStatus getStatusById(long id) {
            ActivityStatus found = new ActivityStatus();
            found.setIdActivityStatus(getStatusEnumById(id).getId());
            return found;
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
