package org.jiji.trapp.dao;


import org.jiji.trapp.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetDao extends JpaRepository<Asset, Long> {
}
