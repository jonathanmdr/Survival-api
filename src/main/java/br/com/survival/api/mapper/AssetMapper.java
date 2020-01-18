package br.com.survival.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.survival.api.dto.AssetDTO;
import br.com.survival.domain.model.Asset;

@Component
public class AssetMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AssetDTO toDto(Asset asset) {
		return modelMapper.map(asset, AssetDTO.class);
	}
	
	public List<AssetDTO> toCollectionDto(List<Asset> assets) {
		return assets.stream().map(asset -> toDto(asset)).collect(Collectors.toList());
	}

}
