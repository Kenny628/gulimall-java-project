/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com._yzhheng.exception.UserNameException;
import com._yzhheng.persistence.entities.UmsMember;
import com._yzhheng.persistence.repositories.UmsMemberRepository;
import com._yzhheng.rest.dto.UmsMemberDTO;
import com._yzhheng.rest.services.commons.GenericService;
import com._yzhheng.vo.MemberLoginVo;
import com._yzhheng.vo.MemberRegisVo;
import com._yzhheng.vo.SocialUserLogin;

/**
 * REST service for entity "UmsMember" <br>
 * 
 * This service provides all the necessary operations required by the REST
 * controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class UmsMemberService extends GenericService<UmsMember, UmsMemberDTO> {

	private static final Logger logger = LoggerFactory.getLogger(UmsMemberService.class);

	private final UmsMemberRepository repository; // injected by constructor

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public UmsMemberService(UmsMemberRepository repository) {
		super(UmsMember.class, UmsMemberDTO.class);
		this.repository = repository;
	}

	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Long getEntityId(UmsMemberDTO dto) {
		return dto.getId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<UmsMemberDTO> findAll() {
		logger.debug("findAll()");
		Iterable<UmsMember> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param id
	 * @return the entity or null if not found
	 */
	public UmsMemberDTO findById(Long id) {
		Long entityId = id;
		logger.debug("findById({})", entityId);
		Optional<UmsMember> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param id
	 * @param dto
	 */
	public void save(Long id, UmsMemberDTO dto) {
		Long entityId = id;
		logger.debug("save({},{})", entityId, dto);
		// force PK in DTO (just to be sure to conform with the given PK)
		dto.setId(id);
		repository.save(dtoToEntity(dto));
	}

	/**
	 * Updates the given entity if it exists
	 *
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean update(UmsMemberDTO dto) {
		logger.debug("update({})", dto);
		if (repository.existsById(getEntityId(dto))) {
			repository.save(dtoToEntity(dto));
			return true; // find and updated
		} else {
			return false; // not found (not updated)
		}
	}

	/**
	 * Updates partially the given entity if it exists
	 *
	 * @param id
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean partialUpdate(Long id, UmsMemberDTO dto) {
		Long entityId = id;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<UmsMember> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			UmsMember entity = optionalEntity.get();
			// implement here the partial update
			// entity.setXxx(dto.getXxx());
			// etc ...
			repository.save(entity);
			return true; // find and updated
		} else {
			return false; // not found (not updated)
		}
	}

	/**
	 * Creates the given entity
	 *
	 * @param dto
	 * @return true if created, false if already exists
	 */
	public boolean create(UmsMemberDTO dto) {
		logger.debug("create({})", dto);
		// auto-generated Primary Key
		repository.save(dtoToEntity(dto));
		return true; // always created
	}

	/**
	 * Deletes an entity by its PK
	 *
	 * @param id
	 * @return true if deleted, false if not found
	 */
	public boolean deleteById(Long id) {
		Long entityId = id;
		logger.debug("deleteById({})", entityId);
		if (repository.existsById(entityId)) {
			repository.deleteById(entityId);
			return true; // find and deleted
		} else {
			return false; // not found (not deleted)
		}
	}

	public void register(MemberRegisVo memberRegisVo) throws UserNameException {
		// TODO Auto-generated method stub
		UmsMember entity = new UmsMember();
		entity.setLevelId(1L);

		checkUserNameUnique(memberRegisVo.getUserName());
		entity.setUsername(memberRegisVo.getUserName());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode(memberRegisVo.getPassword());
		entity.setPassword(encoded);
		repository.save(entity);
	}

	public void checkUserNameUnique(String userName) throws UserNameException {
		int count = repository.countUserName(userName);
		if (count > 0) {
			throw new UserNameException();
		}
	}

	// -----------------------------------------------------------------------------------------
	// Specific "finders"
	// -----------------------------------------------------------------------------------------
	/***
	 * public List<UmsMemberDTO> findByTitle(String title) {
	 * logger.debug("findByTitle({})", title);
	 * // List<UmsMember> list = repository.findByTitle(title);
	 * List<UmsMember> list = repository.findByTitleContaining(title);
	 * return entityListToDtoList(list);
	 * }
	 * 
	 * public List<UmsMemberDTO> findByPrice(BigDecimal price) {
	 * logger.debug("findByPrice({})", price);
	 * // List<UmsMember> list = repository.findByTitle(title);
	 * List<UmsMember> list = repository.findByPrice(price);
	 * return entityListToDtoList(list);
	 * }
	 * 
	 * public List<UmsMemberDTO> findByTitleAndPrice(String title, BigDecimal price)
	 * {
	 * logger.debug("findByTitleAndPrice({}, {})", title, price);
	 * List<UmsMember> list = repository.findByTitleContainingAndPrice(title,
	 * price);
	 * return entityListToDtoList(list);
	 * }
	 ***/

	public UmsMember login(MemberLoginVo userLoginVo) {
		// TODO Auto-generated method stub
		UmsMember member = repository.findUserByName(userLoginVo.getLoginacct());
		if (member == null) {
			return null;
		} else {
			String passwordDb = member.getPassword();
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			boolean matches = bCryptPasswordEncoder.matches(userLoginVo.getPassword(), passwordDb);
			if (matches) {
				return member;
			} else {
				return null;
			}
		}
	}

	public UmsMember login(SocialUserLogin socialUserLogin) {
		// TODO Auto-generated method stub
		UmsMember member = repository.findUserBySocialUid(socialUserLogin.getRetrievedUserId());
		if (member == null) {
			// return null;
			UmsMember newMember = new UmsMember();
			newMember.setLevelId(1L);
			newMember.setUsername(socialUserLogin.getRetrievedUsername());
			newMember.setSocialUid(socialUserLogin.getRetrievedUserId());
			newMember.setAccessToken(socialUserLogin.getAccess_token());
			newMember.setNickname(socialUserLogin.getRetrievedUsername());
			repository.save(newMember);
			return newMember;
		} else {
			// member.setAccessToken(socialUserLogin.getAccess_token());
			repository.updateAccessTokenBySocialUid(socialUserLogin.getRetrievedUserId(),
					socialUserLogin.getAccess_token());
			member.setAccessToken(socialUserLogin.getAccess_token());
			return member;
		}
	}
}
