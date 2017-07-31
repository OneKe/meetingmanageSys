package com.chinasofti.mms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
import com.chinasofti.mms.pojo.MeetingRoom;

@Repository
public interface MeetingParticipantsMapper {
    
    int deleteByPrimaryKey(Integer mpid);

    int insert(MeetingParticipants record);

    int insertSelective(MeetingParticipants record);

    MeetingParticipants selectByPrimaryKey(Integer mpid);

    int updateByPrimaryKeySelective(MeetingParticipants record);

    int updateByPrimaryKey(MeetingParticipants record);

    /**
     * 登陆后，根据用户的用户id查询我的预定
     * @param id
     * @return
     */
	List<Map<String, Object>> selectByEmployeeName(String id);

	/**
	 * 用户登录
	 * @param employee
	 * @return
	 */
	Employee findlogin(Employee employee);
	
	/**
	 * 在最新通知里显示：未来7天我要参加的会议
	 */
	List<Map<String,Object>> selectMeetingByOrder(String id);

	/**
	 * 在最新通知里显示：已取消的会议
	 */
	List<Map<String, Object>> cancelMeetingMap();
	
	/**
	 * 修改密码
	 * @param loginUserName
	 * @param originpassword
	 * @param newpassword
	 * @return
	 */
	boolean updateNewPassword(String loginUserName, String originpassword, String newpassword);
	
	/**
	 * 通过会议id，查询会议详情
	 * @param meetingId
	 * @return
	 */
	Meeting selectByMyMeetingById(String meetingId);

	/**
	 *  通过会议id，查询参加该会议的所有员工
	 * @param meetingId
	 * @return
	 */
	List<Employee> selectEmployeeByMeetingId(String meetingId);

	/**
	 *   --------人员管理： 搜索员工
	 * @param paramMap
	 * @return
	 */
	List<Employee> findEmployee(Map<String, Object> paramMap);

	/**
	 * --------人员管理： 搜索员工-----关闭账号
	 * @param id
	 * @param status
	 * @return
	 */
	int updateEmployeeStatus(String id, int status);

	/**
	 * ------个人中心 > 最新通知 > 撤销会议
	 * @param mtid
	 * @param canceledreson 
	 * @return
	 */
	int cancelOneMeeting(String mtid, String canceledreson);
	
	//批量添加
	int insertMpt(List<MeetingParticipants> list);

	/**
	 * -----会议预定 > 查看所有会议室
	 * @return
	 */
	List<Map<String, Object>> selectAllMeetingRoom();

	/**
	 * -----会议预定 > 查看所有会议室 > 会议室详情
	 * @param id
	 * @return
	 */
	MeetingRoom selectOneMeetingRoom(String id);

	/**
	 * -----会议预定 > 查看所有会议室 > 会议室详情 > 确认修改会议室信息
	 * @param mr
	 * @return
	 */
	int updateMeetingRoom(MeetingRoom mr);

	/**
	 * 根据员工状态查出所有员工的个数，为分页准备
	 * @param startS
	 * @return
	 */	
	List<Employee> findUserList(int startS);

	/**
	 * 按照页面的条件不分页，查出符合条件的总条数
	 * @param employeeName
	 * @param accountName
	 * @param intStatus
	 * @return
	 */
	Integer searchTotalCount(String employeeName, String accountName, int intStatus);

}