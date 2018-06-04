package tnl.group

import kotlin.coroutines.experimental.buildSequence

class Group(val permissions: Iterable<String>, val memberOfGroups: Iterable<Group> = listOf())


fun Group.getAllPermissions1(): Set<String> {
    val result = HashSet<String>()

    result.addAll(permissions)
    memberOfGroups.forEach {group ->
        result.addAll(group.getAllPermissions1())
    }
    return result
}

fun Group.getAllPermissions2(): Set<String> {
    return permissionSequence().toHashSet()
}

private fun Group.permissionSequence(): Sequence<String> {
    return buildSequence {
        yieldAll(permissions)
        memberOfGroups.forEach { group ->
            yieldAll(group.permissionSequence())
        }
    }
}
