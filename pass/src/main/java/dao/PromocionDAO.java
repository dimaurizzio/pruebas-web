package dao;

import promociones.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {

    void insertPromo(Promocion promocion, String promotionTipe);
}
